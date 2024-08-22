const btn = document.querySelectorAll(".btn");

btn.forEach(function (button) {
  button.onclick = function () {
    const movieInfo = this.closest("li");
    const title = movieInfo.querySelector(".title").textContent;
    const genre = movieInfo.querySelector(".genre").textContent;
    const director = movieInfo.querySelector(".director").textContent;
    const runningTime = movieInfo.querySelector(".runningTime").textContent;

    console.log(title);
    console.log(genre);
    console.log(director);
    console.log(runningTime);
  };
});