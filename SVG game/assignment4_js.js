// Define a namespace for SVG elements
const svgNS = "http://www.w3.org/2000/svg";

// Get references to the SVG elements in the HTML file
var canvas = document.querySelector("#canvas");
var sky = document.querySelector("#sky");

// Define a function to create a pair of game walls
function gameWall() {

    var upperheight = Math.floor(Math.random() * 440);
    
    var bottomheight = Math.floor(Math.random() * 15) + (500-(upperheight+75));
    // create the upper wall
    function upperWall(){
        let wall = document.createElementNS( svgNS, "rect" );

        wall.setAttribute( "height", upperheight );
        wall.setAttribute( "width", "20");
        wall.setAttribute( "x", (sky.getAttribute("width")));
        wall.setAttribute( "y", "0" );
        wall.setAttribute( "stroke", "black" );
        wall.setAttribute( "stroke-width", "2" );
        wall.setAttribute( "fill", "darkgreen");
        wall.setAttribute( "id", "wall1" );

        // add the upper wall to the canvas
        canvas.appendChild( wall );

        return wall;
    }
    // create the lower wall
    function bottomWall(){
        let wall = document.createElementNS( svgNS, "rect" );

        wall.setAttribute( "height", bottomheight );
        wall.setAttribute( "width", "20");
        wall.setAttribute( "x", (sky.getAttribute("width")));
        wall.setAttribute( "y", (canvas.getAttribute("height")-bottomheight));
        wall.setAttribute( "stroke", "black" );
        wall.setAttribute( "stroke-width", "2" );
        wall.setAttribute( "fill", "darkgreen");
        wall.setAttribute( "id", "wall2" );

        // add the lower wall to the canvas
        canvas.appendChild( wall );

        return wall;
    }
  
    // create the walls and store them in an array
    let upperBlock = upperWall();
    let bottomBlock = bottomWall();
    let gameWalls = [upperBlock, bottomBlock];
    return gameWalls;
}
// initialize gameBlocks array
var wall1 = document.getElementById("wall1");;
var wall2 = document.getElementById("wall2");
var gameBlocks = [];


/** function to create an array of game walls*/
function array(){
let first_wall = gameWall();
gameBlocks.push( first_wall );
}
// create the initial array of game walls
array();
// get the location of the cube
var cubeLocation = document.getElementById("cube");

/**
 * Moves the walls to the left by decreasing the x position of block1 and block2 attributes by 0.5. 
 * Removes the walls from the canvas if both have an x position less than 25.
 * Checks if the cube collides with either wall, and if so, stops the moving block and scoreBoard intervals, 
 * removes the walls from the canvas, and resets the score to 0. 
 * 
 * @param {Element} block1 - The first wall block element.
 * @param {Element} block2 - The second wall block element.
 */


function move_wall(block1,block2) {

  // get the wall elements and move the walls to the left
  block1 = document.querySelector("#wall1");
  block1.setAttribute("x", (block1.getAttribute("x"))-0.5);
  block2 = document.querySelector("#wall2");
  block2.setAttribute("x", (block2.getAttribute("x"))-0.5);

  // if both walls are off the screen, remove them and add new ones
  if ((block1.getAttribute("x")-25 < 0 ) && (block2.getAttribute("x")-25 < 0 )) {
    canvas = document.querySelector( "#canvas" );
    canvas.removeChild( block1 );
    canvas.removeChild( block2 );
    
    array();
  }

  // check for collisions between the walls and the cube
  let wall1X = parseFloat(block1.getAttribute("x")); 
  let wall1height = parseFloat(block1.getAttribute("height")); 
  let wall2Y = parseFloat(block2.getAttribute("y"));
  let cubeY = parseFloat(cubeLocation.getAttribute("y"));
  
  if(wall1X < 125 && wall1X > 65){
    if((wall1height >= cubeY)){
      clearInterval(movingBlock);
      clearInterval(scoreBoard);
      canvas.removeChild( block1 );
      canvas.removeChild( block2 );
      array();
      score = 0;
    }

    if((wall2Y <= (cubeY+40))){
      clearInterval(movingBlock);
      clearInterval(scoreBoard);
      canvas.removeChild( block1 );
      canvas.removeChild( block2 );
      array();
      score = 0;
    }
  } 
}

/**
 * Moves the walls to the left by decreasing the x position of block1 and block2 attributes by 0.65. 
 * Removes the walls from the canvas if both have an x position less than 25.
 * Checks if the cube collides with either wall, and if so, stops the moving block and scoreBoard intervals, 
 * removes the walls from the canvas, and resets the score to 0. 
 * 
 * @param {Element} block1 - The first wall block element.
 * @param {Element} block2 - The second wall block element.
 */

function move_wall2(block1,block2) {

  // get the wall elements and move the walls to the left
  block1 = document.querySelector("#wall1");
  block1.setAttribute("x", (block1.getAttribute("x"))-0.65);
  
  block2 = document.querySelector("#wall2");
  block2.setAttribute("x", (block2.getAttribute("x"))-0.65);
  
// if both walls are off the screen, remove them and add new ones
  if ((block1.getAttribute("x")-25 < 0 ) && (block2.getAttribute("x")-25 < 0 )) {
    canvas = document.querySelector( "#canvas" );
    canvas.removeChild( block1 );
    canvas.removeChild( block2 );
    
    array();
  }
  // check for collisions between the walls and the cube
  let wall1X = parseFloat(block1.getAttribute("x")); 
  let wall1height = parseFloat(block1.getAttribute("height")); 
  let wall2Y = parseFloat(block2.getAttribute("y"));
  let cubeY = parseFloat(cubeLocation.getAttribute("y"));
  
  if(wall1X < 125 && wall1X > 65){
    if((wall1height >= cubeY)){
      clearInterval(movingBlock);
      clearInterval(scoreBoard);
      canvas.removeChild( block1 );
      canvas.removeChild( block2 );
      array();
      score = 0;
    }

    if((wall2Y <= (cubeY+40))){
      clearInterval(movingBlock);
      clearInterval(scoreBoard);
      canvas.removeChild( block1 );
      canvas.removeChild( block2 );
      array();
      score = 0;
    }
  } 
}

var movingBlock;
var scoreBoard;
var score = 0;
var highScore = score;
var startbtn = document.getElementById("startbtn");
var startbtn2 = document.getElementById("startbtn2");

// Define onclick behavior for Play Game button
startbtn.onclick = function () {
  
  // Clear any existing intervals
  clearInterval(movingBlock);
  clearInterval(scoreBoard);

  // Reset cube location and score
  cubeLocation.setAttribute( "y", "220");
  score = 0;

  // Pause sky animation
  sky.style.animationPlayState = "paused";
 
  // Start interval for moving blocks   
  movingBlock = setInterval(function(){
    move_wall();
  },5)

  // Start interval for updating score
  scoreBoard = setInterval(function(){
    // Update score
    document.getElementById("score").innerHTML = "Score: " + score;
    score++;
    // Update high score if necessary
    if (score >= highScore){
      highScore = score-1;
    }
    document.getElementById("highscore").innerHTML = highScore;
  },250);
}

// Define onclick behavior for Play Fast Mode button
startbtn2.onclick = function () {
  
  // Clear any existing intervals
  clearInterval(movingBlock);
  clearInterval(scoreBoard);

  // Reset cube location and score
  cubeLocation.setAttribute( "y", "220");
  score = 0;

  // Resume sky animation
  sky.style.animationPlayState = "running";

  // Start interval for moving blocks 
  movingBlock = setInterval(function(){
    move_wall2();
  },1.5)

  // Start interval for updating score
  scoreBoard = setInterval(function(){
    // Update score
    document.getElementById("score").innerHTML = "Score: " + score;
    score++;
    // Update high score if necessary
    if (score >= highScore){
      highScore = score-1;
    }
    document.getElementById("highscore").innerHTML = highScore;
  },250);
}

// When left click is detected, move cube up
document.addEventListener("click", function(){
  let cubeLocation = document.getElementById("cube");
  if (cubeLocation.getAttribute("y") > 0){
  cubeLocation.setAttribute("y", (cubeLocation.getAttribute("y"))-20);}
});

// When right click is detected, move cube down
document.addEventListener("contextmenu", function(){
  let cubeLocation = document.getElementById("cube");
  if ((cubeLocation.getAttribute("y")) <= 455){
  cubeLocation.setAttribute("y", (cubeLocation.getAttribute("y"))-10+30);}
});

// Prevent context menu from appearing on right click
document.addEventListener("contextmenu", (c) => {c.preventDefault()});
