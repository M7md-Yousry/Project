function populateForm() {
    const params = new URLSearchParams(window.location.search);

    document.querySelector(".fullname").value = params.get("fullname") || "";
    document.querySelector(".address").value = params.get("address") || "";
    document.querySelector(".maritalstatus").value = params.get("maritalstatus") || "";
    document.querySelector(".department").value = params.get("department") || "";
    document.querySelector(".githuburl").value = params.get("githuburl") || "";
}

window.onload = populateForm;

document.addEventListener("DOMContentLoaded", function (){

document.querySelector(".form").addEventListener("submit", function (e) {
    e.preventDefault();

    const id = new URLSearchParams(window.location.search).get("id");
    const fullname = document.querySelector(".fullname").value;
    const address = document.querySelector(".address").value;
    const maritalstatus = document.querySelector(".maritalstatus").value;
    const department = document.querySelector(".department").value;
    const githuburl = document.querySelector(".githuburl").value;

    const updatedContent = {
        id,
        fullname,
        address,
        maritalstatus,
        department,
        githuburl};

    console.log(updatedContent);

    fetch(`http://localhost:8080/api/content/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedContent)
    })
        .then(response => {
            if (response.ok) {
                window.location.href = "/";
            } else {
                throw new Error('Failed to update content');
            }
        })
        .catch(error => console.error('Error updating content:', error));
});
});
