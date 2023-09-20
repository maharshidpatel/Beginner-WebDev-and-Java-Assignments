/**Author: Maharshi patel, 000738366, Date: April 02, 2023
* Purpose: The purpose of the code is to demonstrate how to make API requests using JavaScript's fetch() method and manipulate the received data to display it on 
* a webpage. The code includes three functions, each triggered by a button click, that use fetch() to make requests to an external API and display the response data in 
* different formats on the webpage.
*/
var userChoice = "mario";
/**
 * Executes a fetch request to retrieve data and calls the B1 function to update the page header
 *
 * @param {string} answer - the text returned by the server to update the header
 */
function B1(answer) {
	// Get the header element from the DOM
	let header = document.getElementById("header");
	// Create the HTML for the header
	let h1 = '<h1>' + answer + '</h1>'
	let h2 = '<h1>Maharshi Patel - 000738366</h1>'
	header.innerHTML = h1 + h2;
}

// Add event listener for button1 click
let button1 = document.getElementById("button1");
button1.addEventListener("click", function () {

	let url = "https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php"

	// Fetch data from the specified URL
	fetch(url)
		.then(response => response.text())
		.then(B1);
});

/**
 * Executes a fetch request to retrieve data and calls the B2 function to display character images
 *
 * @param {Object[]} characters - an array of character objects with properties for name, series, and url
 */
function B2(characters) {
	// Get the pics element from the DOM
	let pics = document.getElementById("pics");
	// Calculate the responsive column width based on the number of characters
	let responsive = (12 / characters.length);

	// Create the HTML for each character image and name
	let div = '';

	characters.forEach(character => {

		div += '<div class="col-lg-' + responsive + ' px-0 text-center col align-self-center">';
		div += '<div class="h2 mb-0 text-center border border-dark">' + character.series + '</div>';
		div += '<div class="text-center border border-dark"><img class="img-fluid" src="' + character.url + '" alt="Character Picture"></div>';
		div += '<div class="text-center fs-5 border border-dark">' + character.name + '</div>';
		div += '</div>'
	});

	// Create the HTML for the copyRight text based on the userChoice
	let copyRight = '';
	if (userChoice == "mario") {
		copyRight += '<div class="border border-dark text-center">Game trademarks and copyrights are properties of their respective owners. Nintendo properties are trademarks of Nintendo. &copy; 2019 Nintendo.</div>';
	}

	if (userChoice == "starwars") { copyRight += '<div class="border border-dark text-center">Star Wars &copy; & TM 2022 Lucasfilm Ltd. All rights reserved. Visual material &copy; 2022 Electronic Arts Inc.</div>'; }

	pics.innerHTML = div + copyRight;
}

// Add event listener for button2 click
let button2 = document.getElementById("button2");
button2.addEventListener("click", function choice() {

	// Get the user's choice from the selected radio button
	let choices = document.querySelectorAll("input");

	choices.forEach(c => {
		if (c.checked)
			userChoice = c.value;
	}
	);

	let choice = "?choice=" + userChoice;
	let url = "https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php" + choice;

	// Fetch data from the specified URL, passing the user's choice as a query parameter
	fetch(url, { credentials: 'include' })
		.then(response => response.json())
		.then(B2);
});

/**
 * Executes a fetch request to retrieve data and calls the B3 function to display character data in a table
 *
 * @param {Object[]} data - an array of character objects with properties for name, series, and url
 */
function B3(data) {
	// Get the table and tableCopyRight elements from the DOM
	let table = document.getElementById("data");
	let tableCopyRight = document.getElementById("tableCopyRight");

	// Create the HTML for the table headers
	let th = '<thead class="text-center"><tr><th>Series</th><th>Name</th><th>Link</th></tr></thead>';

	// Create the HTML for each row of character data
	let rows = "";

	data.forEach(row => {

		rows += "<tr class='text-center'>";

		rows += "<td>" + row.series + "</td>";
		rows += "<td>" + row.name + "</td>";
		rows += "<td>" + row.url + "</td>";

		rows += "</tr>";
	});

	// Create the HTML for the copyRight text based on the userChoice
	let copyRight = '';

	if (userChoice == "mario") {
		copyRight += '<div class="border border-dark text-center col-12">Game trademarks and copyrights are properties of their respective owners. Nintendo properties are trademarks of Nintendo. &copy; 2019 Nintendo.</div>';
	}

	if (userChoice == "starwars") { copyRight += '<div class="border border-dark text-center col-12">Star Wars &copy; & TM 2022 Lucasfilm Ltd. All rights reserved. Visual material &copy; 2022 Electronic Arts Inc.</div>'; }


	table.innerHTML = th + rows;
	tableCopyRight.innerHTML = copyRight;

}

// Add event listener for button3 click

let button3 = document.getElementById("button3");
button3.addEventListener("click", function choice() {

	// Get the user's choice from the selected radio button
	let choices = document.querySelectorAll("input");

	choices.forEach(c => {
		if (c.checked)
			userChoice = c.value;
	}
	);

	let choice = "choice=" + userChoice;

	let url = "https://csunix.mohawkcollege.ca/~adams/10259/a6_responder.php";

	// Post the user's choice to the specified URL
	fetch(url, {
		method: 'POST', credentials: 'include', headers: { "Content-Type": "application/x-www-form-urlencoded" }, body: choice
	})
		.then(response => response.json())
		.then(B3);
});

