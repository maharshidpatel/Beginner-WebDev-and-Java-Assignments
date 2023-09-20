/**Author: Maharshi patel, 000738366, Date: Feb 12, 2023
* Purpose: This webpage is created to practice Bootstrap’s JavaScript components and writing solutions to
* problems using JavaScript from scratch.
*/

/** This function checks input's with if else conditions range */

function group_1_choice_1() {

    let q1_input = document.getElementById("q1_input").value;

    let q1_output = document.getElementById("q1_output");


    if (q1_input == 0 || (q1_input >= 13 && q1_input <= 17)) {
        q1_output.innerHTML = "In range";
    }

    else if (isNaN(q1_input)) {
        q1_output.innerHTML = "Not a number";
    }

    else {
        q1_output.innerHTML = "Out of range";
    }
}

/** This function multiply input by 4 and square input's value if it's number*/

function group_1_choice_3() {

    let q2_input = document.getElementById("q2_input").value;

    let q2_output1 = document.getElementById("q2_output1");

    let q2_output2 = document.getElementById("q2_output2");

    let Perimeter = q2_input * 4

    let Area = q2_input * q2_input

    if (q2_input >= 0 && (!isNaN(q2_input))) {

        q2_output1.innerHTML = "Perimeter: " + Perimeter;

        q2_output2.innerHTML = "Area: " + Area;

    }

    else if (isNaN(q2_input) || q2_input < 0) {

        q2_output1.innerHTML = "Can’t calculate";
        q2_output2.innerHTML = "Can’t calculate";
    }

}

/** This function add up all digits of the interger input until it become single digit number */

function group_2_choice_2() {

    let q3_input = document.getElementById("q3_input").value;

    let q3_output = document.getElementById("q3_output");

    if (!isNaN(q3_input) && q3_input == parseInt(q3_input)) {

        if (q3_input >= 0) {

            let len = q3_input.toString().length;
            let i = 0;
            let sum = 0;
            let num = 0;

            if (len > 1) {
                while (len > 1) {
                    for (i; i < len; i++) {
                        num = q3_input.toString().substring(i, i + 1);
                        num = parseInt(num);
                        sum += num;
                    }
                    q3_input = sum;
                    len = q3_input.toString().length;
                    sum = 0;
                    i = 0;
                }
                q3_output.innerHTML = q3_input;
            }
            else {
                q3_output.innerHTML = q3_input;
            }
        }
    }

    else {
        q3_output.innerHTML = "Bad input";
    }
}

/** This function count the factorial value of interger input */

function group_2_choice_3() {

    let q4_input = document.getElementById("q4_input").value;

    let q4_output = document.getElementById("q4_output")

    if (!isNaN(q4_input) && (q4_input == parseInt(q4_input))) {

        if (q4_input > 0) {

            let counter = 1;
            let factorial = 1;

            while (counter <= q4_input) {
                factorial = factorial * counter;
                counter++;
            }
            q4_output.innerHTML = factorial;
        }

        else {
            q4_output.innerHTML = "Cannot compute factorial value";
        }
    }

    else {
        q4_output.innerHTML = "Cannot compute factorial value";
    }

}

/** This function convert whole/interger binary number to interger decimal only if binary number have between 10 and 20 digits inclusive */

function group_3_choice_1() {

    let q5_input = document.getElementById("q5_input").value;

    let q5_output = document.getElementById("q5_output")

    if (q5_input.length >= 10 && q5_input.length <= 20) {

        let i = 0;

        let numLen = q5_input.length;

        let binaryToInteger = 0;

        let validBinary = true;

        for (i; i < numLen; i++) {

            if ((q5_input.substring(i, i + 1) !== "0") && (q5_input.substring(i, i + 1) !== "1")) {

                validBinary = false;

            }
        }

        i = 0;

        if (validBinary) {

            for (i; i < numLen; i++) {

                if ((q5_input.substring(i, i + 1) === "1")) {

                    binaryToInteger += Math.pow(2, numLen - (i + 1));

                }
            }
        }

        q5_output.innerHTML = binaryToInteger;

    }

    else {
        q5_output.innerHTML = "0";
    }

}
