//this is the digital clock program
function updateClock(){
    const now = new Date();
    const hours = now.getHours().toString().padStart(2,0);
    const minutes = now.getMinutes().toString().padStart(2,0);
    const seconds = now.getSeconds().toString().padStart(2,0);
    const miliseconds = now.getMilliseconds().toString().padStart(3,0);

   // console.log(hours+":" + minutes + ":" + seconds+ ":" + miliseconds);
    const timeString = `${hours}:${minutes}:${seconds}:${miliseconds}` //use the non shift tilda to do this instead of single quotes
    document.getElementById("clock").textContent = timeString;
}

updateClock();
setInterval(updateClock, 100);
//while(true){updateClock();}