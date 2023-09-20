/**Author: Maharshi patel, 000738366, Date: March 04, 2023
* Purpose: This webpage is created to practice JavaScript to respond to events and to read inputs and write
* outputs from/to the DOM.
*/

var secTimeout;
var secTimeout2;
var imageCount = 0;
var miliSec = 0;
var sec = 10;
var randomBtn = document.getElementById("randomBtn");
var img1 = document.getElementById("image1");
var img2 = document.getElementById("image2");
var img3 = document.getElementById("image3");
var outputColor;

/** Spins the image by adding and removing the "spin" class to the target image element.
* @param {Event} event - The event that triggered the function.
*/
function spinImage(event) {
    var targetImage = event.target;
    targetImage.classList.add('spin');
    setTimeout(() => {
        targetImage.classList.remove('spin');
    }, 1000);
}

/** This function loads with webpage and displays image and runs timer. Also executes all function upon user ineraction*/
window.onload = function () {

    img1 = document.getElementById("image1");
    img2 = document.getElementById("image2");
    img3 = document.getElementById("image3");

    //Images Collection
    imageUrl = ['./images/coffee1.jpg', './images/coffee2.jpg', './images/coffee3.jpg', './images/coffee4.jpg', './images/mountain1.jpg', './images/mountain2.jpg', './images/mountain3.jpg', './images/mountain4.jpg', './images/peacock1.jpg', './images/peacock2.jpg', './images/peacock3.jpg', './images/peacock4.jpg']

    img1.src = imageUrl[Math.floor(Math.random() * 12)];
    img2.src = imageUrl[Math.floor(Math.random() * 12)];
    img3.src = imageUrl[Math.floor(Math.random() * 12)];

    randomBtn = document.getElementById("randomBtn");

    document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";

    /** This function picks 3 random images from collection and replace the current ones, resets timer and adds 3 upon every click*/

    randomBtn.onclick = function () {
        img1.src = imageUrl[Math.floor(Math.random() * 12)];
        img2.src = imageUrl[Math.floor(Math.random() * 12)];
        img3.src = imageUrl[Math.floor(Math.random() * 12)];
        imageCount = imageCount + 3;
        document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";

        sec = 10;
        miliSec = 0;
    };

    sec = 10;
    miliSec = 0;

    //Automatic timer runs when webpage loads and picks 3 random images from collection and replace the current ones when timer resets.
    secTimeout = setInterval(function () {

        if ((sec + (miliSec / 10)) > (10 * (2 / 3))) {
            outputColor = "text-bg-success";
        }
        if ((sec + (miliSec / 10)) <= (10 * (2 / 3)) && (sec + (miliSec / 10)) > (10 * (1 / 3))) {
            outputColor = "text-bg-warning";
        }
        if ((sec + (miliSec / 10)) <= (10 * (1 / 3))) {
            outputColor = "text-bg-danger";
        }

        document.getElementById("timeDisplay").innerHTML = "<span class='" + outputColor + "'>" + sec + "." + miliSec + "</span>";

        if (miliSec == 0) {
            sec--;
            miliSec = 10;
        }

        if (sec < 0) {
            sec = 10;
            miliSec = 1;

            img1.src = imageUrl[Math.floor(Math.random() * 12)];
            img2.src = imageUrl[Math.floor(Math.random() * 12)];
            img3.src = imageUrl[Math.floor(Math.random() * 12)];

            imageCount = imageCount + 3;
            document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
        }

        miliSec--;
    }, 100);


    /** These functions picks a random images from collection and replace the current ones, resets timer, Spins the image and adds 1 upon every click*/
    img1.onclick = function () {
        spinImage(event);
        img1.src = imageUrl[Math.floor(Math.random() * 12)];
        imageCount++;
        document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
        sec = 10;
        miliSec = 0;
    };

    img2.onclick = function () {
        spinImage(event);
        img2.src = imageUrl[Math.floor(Math.random() * 12)];
        imageCount++;
        document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
        sec = 10;
        miliSec = 0;
    };

    img3.onclick = function () {
        spinImage(event);
        img3.src = imageUrl[Math.floor(Math.random() * 12)];
        imageCount++;
        document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
        sec = 10;
        miliSec = 0;
    };
}

/** This function loads dynamic timer. Also executes all function upon user ineraction.*/
function changeTime() {

    var miliSecInput = document.getElementById("timeout").value;
    miliSecInput = parseInt(miliSecInput);

    if (miliSecInput >= 500 && miliSecInput <= 10000 && miliSecInput == parseInt(miliSecInput) && !isNaN(miliSecInput)) {

        clearInterval(secTimeout2);
        clearInterval(secTimeout);
        var outputColor2;

        miliSec = parseInt((miliSecInput % 1000) / 100);
        sec = parseInt(miliSecInput / 1000);

        //Dynamic Timer
        //Picks 3 random images from collection and replace the current ones when timer resets.
        secTimeout2 = setInterval(function () {

            if ((sec + (miliSec / 10)) > ((miliSecInput * (2 / 3)) / 1000)) {
                outputColor2 = "text-bg-success";
            }
            if ((sec + (miliSec / 10)) <= ((miliSecInput * (2 / 3)) / 1000) && (sec + (miliSec / 10)) > ((miliSecInput * (1 / 3)) / 1000)) {
                outputColor2 = "text-bg-warning";
            }
            if ((sec + (miliSec / 10)) <= ((miliSecInput * (1 / 3)) / 1000)) {
                outputColor2 = "text-bg-danger";
            }

            document.getElementById("timeDisplay").innerHTML = "<span class='" + outputColor2 + "'>" + sec + "." + miliSec + "</span>";

            if (miliSec == 0) {
                sec--;
                miliSec = miliSec + 10;
            }

            if (sec < 0) {
                sec = sec + parseInt(miliSecInput / 1000) + 1;
                miliSec = parseInt((miliSecInput % 1000) / 100) + 1;

                img1.src = imageUrl[Math.floor(Math.random() * 12)];
                img2.src = imageUrl[Math.floor(Math.random() * 12)];
                img3.src = imageUrl[Math.floor(Math.random() * 12)];

                imageCount = imageCount + 3;
                document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
            }
            miliSec--;
        }, 100);

        /** This function picks 3 random images from collection and replace the current ones, resets timer and adds 3 upon every click*/

        randomBtn.onclick = function () {
            img1.src = imageUrl[Math.floor(Math.random() * 12)];
            img2.src = imageUrl[Math.floor(Math.random() * 12)];
            img3.src = imageUrl[Math.floor(Math.random() * 12)];
            imageCount = imageCount + 3;
            document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";
            miliSec = parseInt((miliSecInput % 1000) / 100);
            sec = parseInt(miliSecInput / 1000);
        };

        /** These functions picks a random images from collection and replace the current ones, resets Dynamic timer, Spins the image and adds 1 upon every click*/

        img1.onclick = function () {
            spinImage(event);
            img1.src = imageUrl[Math.floor(Math.random() * 12)];
            imageCount++;
            document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";

            miliSec = parseInt((miliSecInput % 1000) / 100);
            sec = parseInt(miliSecInput / 1000);
        };

        img2.onclick = function () {
            spinImage(event);
            img2.src = imageUrl[Math.floor(Math.random() * 12)];
            imageCount++;
            document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";

            miliSec = parseInt((miliSecInput % 1000) / 100);
            sec = parseInt(miliSecInput / 1000);
        };

        img3.onclick = function () {
            spinImage(event);
            img3.src = imageUrl[Math.floor(Math.random() * 12)];
            imageCount++;
            document.getElementById("imageCount").innerHTML = "Image has updated " + imageCount + " times";

            miliSec = parseInt((miliSecInput % 1000) / 100);
            sec = parseInt(miliSecInput / 1000);
        };
    }
}


