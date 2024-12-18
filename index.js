function updateClock() {
    const now = new Date();
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const seconds = now.getSeconds().toString().padStart(2, '0');
    const milliseconds = now.getMilliseconds().toString().padStart(3, '0');

    const timeString = `${hours}:${minutes}:${seconds}:${milliseconds}`;
    document.getElementById("clock").textContent = timeString;
}

// Use setInterval to update every 100 milliseconds instead of 1 millisecond
updateClock();
setInterval(updateClock, 100);
