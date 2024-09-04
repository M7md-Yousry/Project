fetch("http://localhost:8080/api/content")
    .then((response) => response.json())
    .then((data) => {
        globalData = data;
        loadData(globalData);
    })
    .catch((error) => console.error("Error fetching data:", error));

function loadData(data) {
    let tableBody = document.querySelector(".table tbody");
    tableBody.innerHTML = "";

    data.forEach((item) => {
        let row = document.createElement("tr");

        Object.values(item).forEach((text) => {
            let cell = document.createElement("td");
            cell.textContent = text;
            row.appendChild(cell);
        });

        let editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.classList.add("btn", "btn-primary", "me-2");
        editButton.onclick = function () {
            editRow(item);
        };

        let editCell = document.createElement("td");
        editCell.appendChild(editButton);
        row.appendChild(editCell);

        let deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.classList.add("btn", "btn-danger");
        deleteButton.onclick = function () {
            deleteRow(item.id, row);
        };

        let deleteCell = document.createElement("td");
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);
        tableBody.appendChild(row);
    });
}

function deleteRow(id, row) {
        fetch(`http://localhost:8080/api/content/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => {
                if (response.ok) {
                    row.remove();
                } else {
                    return response.json().then(error => {
                        throw new Error(error.message || 'Failed to delete content');
                    });
                }
            })
            .catch(error => console.error('Error deleting content:', error));
}

function editRow(item) {

    const url = new URL("http://localhost:8080/updatecontent.html");
    url.searchParams.append("id", item.id);
    url.searchParams.append("fullname", item.fullname);
    url.searchParams.append("address", item.address);
    url.searchParams.append("maritalstatus", item.maritalstatus);
    url.searchParams.append("department", item.department);
    url.searchParams.append("githuburl", item.githuburl);

    window.location.href = url.toString();
}