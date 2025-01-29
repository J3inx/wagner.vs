document.addEventListener("DOMContentLoaded", function() {
    const display = document.getElementById("display").querySelector("input");
    const logger = document.getElementById("log");
    const prop = document.getElementById("vmax"); // Vmax input
    const caseLength = document.getElementById("case-length"); // Case length input
    const barrel = document.getElementById("len"); // Barrel length input
    const xmp = document.getElementById("xmp"); // Xmp input

    let failureMessages = [];

    function failure(name) {
        failureMessages.push(name);
    }

    document.getElementById("calculate-btn").addEventListener("click", calculate);

    function calculate() {
        failureMessages = [];

        // Validate inputs
        if (prop.value.length < 1 || isNaN(prop.value)) failure("Vmax");
        if (caseLength.value.length < 1 || isNaN(caseLength.value)) failure("Case length");
        if (barrel.value.length < 1 || isNaN(barrel.value)) failure("Barrel length");
        if (xmp.value.length < 1 || isNaN(xmp.value)) failure("Xmp");

        if (failureMessages.length === 1) {
            logger.value = `One failure detected: ${failureMessages[0]}. Input is either invalid or empty.`;
        } else if (failureMessages.length > 1) {
            logger.value = `Multiple failures detected: ${failureMessages.join(", ")}, are either invalid or empty.`;
        } else {
            logger.value = "All inputs are valid.";

            // Parse input values
            let Vmax = parseFloat(prop.value) || 1200; // Default Vmax (in fps)
            let caseLen = parseFloat(caseLength.value) || 0.75; // Default case length (in inches)
            let barrelLen = parseFloat(barrel.value) || 10; // Default barrel length (in inches)
            let Xmp = parseFloat(xmp.value) || 0.5; // Default Xmp (in inches)

            // Calculate bullet travel distance (x = Barrel Length - Case Length)
            let x = barrelLen - caseLen;

            // Log the values to make sure they are correct
            console.log(`Vmax: ${Vmax}, Case Length: ${caseLen}, Barrel Length: ${barrelLen}, Xmp: ${Xmp}, x: ${x}`);

            // Apply the Le Duc formula: v = Vmax * [x / (x + 2 * Xmp)]
            let velocity = Vmax * (x / (x + 2 * Xmp));

            // Display result
            display.value = velocity.toFixed(2); // Round to 2 decimal places
        }
    }
});
