document.addEventListener("DOMContentLoaded", function() {
    const display = document.getElementById("display").querySelector("input");
    const logger = document.getElementById("log");
    const prop = document.getElementById("prop");
    const mas = document.getElementById("mas");
    const bor = document.getElementById("bor");
    const len = document.getElementById("len");

    let failureMessages = [];  // Array to collect failure names

    function failure(name) {
        failureMessages.push(name);  // Add the failure name to the array
    }

    // Attach the calculate function to the button click event
    document.getElementById("calculate-btn").addEventListener("click", calculate);

    function calculate() {
        // Clear previous failures before starting a new calculation
        failureMessages = [];

        // Check if inputs are valid
        if (prop.value.length < 1 || isNaN(prop.value)) {
            failure("propellant");
        }
        if (mas.value.length < 1 || isNaN(mas.value)) {
            failure("mass");
        }
        if (bor.value.length < 1 || isNaN(bor.value)) {
            failure("bore diameter");
        }
        if (len.value.length < 1 || isNaN(len.value)) {
            failure("barrel length");
        }

        // Output result based on the number of failures
        if (failureMessages.length === 1) {
            logger.value = `One failure detected: ${failureMessages[0]}.`;
        } else if (failureMessages.length > 1) {
            logger.value = `Multiple failures detected: ${failureMessages.join(", ")}.`;
        } else {
            logger.value = "All inputs are valid.";
            
            // Get numeric values for inputs
            let pressure = parseFloat(prop.value) || 52000;  // Default pressure if empty (52,000 psi for .223)
            let mass = parseFloat(mas.value) || 55;  // Default mass in grains (55 gr)
            let bore = parseFloat(bor.value) || 0.16;  // Default bore diameter in inches (0.16 in)
            let length = parseFloat(len.value) || 20;  // Default barrel length in inches (20 in)
            
            // Convert mass from grains to grams (1 grain = 0.06479891 grams)
            mass = mass * 0.06479891;  // Convert from grains to grams
            
            // Calculate the cross-sectional area of the bore (A = π * (d/2)²)
            let area = Math.PI * Math.pow(bore / 2, 2);
            
            // Formula: v = √(2 * P * A * L / m)
            let velocity = Math.sqrt((2 * pressure * area * length) / mass);
            
            // Display the calculated velocity (rounded to 2 decimal places)
            display.value = velocity.toFixed(2);  // Display result as string with 2 decimal places
        }
    }
});
