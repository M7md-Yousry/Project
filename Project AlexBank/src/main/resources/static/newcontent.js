let globalData = [];

fetch("http://localhost:8080/api/content")
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network response was not ok: " + response.statusText);
        }
        return response.json();
    })
    .then((data) => {
        globalData = data;

        const form = document.querySelector(".form");
        if (form) {
            form.addEventListener("submit", function (e) {
                e.preventDefault();
                addContent();
            });
        }
    })
    .catch((error) => console.error("Error fetching data:", error));

function addContent() {
    const id = globalData.length + 1;
    const fullname = document.querySelector(".fullname").value;
    const address = document.querySelector(".address").value;
    const maritalstatus = document.querySelector(".maritalstatus").value;
    const department = document.querySelector(".department").value;
    const githuburl = document.querySelector(".githuburl").value;

    const newContent = {
        id,
        fullname,
        address,
        maritalstatus,
        department,
        githuburl
    };

    globalData.push(newContent);
    console.log(newContent);

    fetch("http://localhost:8080/api/content", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(newContent),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok: " + response.statusText);
            }
        })

        .then(data => {
            document.querySelector(".form").reset();
        })
        .catch(error => console.error("Error submitting data:", error));

}
