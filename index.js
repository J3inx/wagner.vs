function updateClock() {
    const now = new Date();
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const seconds = now.getSeconds().toString().padStart(2, '0');
    const milliseconds = now.getMilliseconds().toString().padStart(3, '0');

    // Ensure milliseconds are always 3 digits
    const timeString = `${hours}:${minutes}:${seconds}:${milliseconds}`;
    document.getElementById("clock").textContent = timeString;
}

// Update every 100ms to avoid excessive frequency
updateClock();
setInterval(updateClock, 100);
