document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("task-form");
  const message = document.getElementById("message");
  const taskList = document.getElementById("task-List");

  //👇🏾 Fonction pour crée un élément <li></li> et l'ajouter dans la liste
  function renderTask(task) {
    const li = document.createElement("li");
    li.textContent = `${task.title} - ${task.description}`;
    //li.className = task.completed ? "completed" : "";
    taskList.appendChild(li);
  }

  //👇🏾 Fonction qui va chercher toutes les tâches depuis l'API
  async function fetchTasks() {
    taskList.innerHTML = ""; // Réinitialise la liste
    try {
      const response = await fetch("http://localhost:8080/api/tasks");
      const tasks = await response.json();
      tasks.forEach(renderTask); // on affiche chaque tâche
    } catch (error) {
      console.error("Erreur lors de la récupération des tâches :", error);
      message.textContent = "❌ Erreur lors de la récupération des tâches.";
    }
  }

  //👇🏾 Soumission du formulaire (création de tâche)
  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const title = document.getElementById("task-title").value;
    const description = document.getElementById("task-description").value;

    const task = {
      title,
      description,
      completed: false,
    };

    try {
      const response = await fetch("http://localhost:8080/api/tasks", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(task),
      });
      if (response.ok) {
        const newTask = await response.json(); // récupère la tâche créée avec l'ID
        message.textContent = "✅ Tâche ajoutée !";
        form.reset();
        renderTask(newTask); // Ajoute la nouvelle tâche à la liste

        //Tu peux rafraîchir la liste des tâches
      } else {
        message.textContent = "❌ Erreur lors de l'ajout de la tâche.";
      }
    } catch (error) {
      message.textContent = "❌ Erreur réseau.";
      console.error(error);
    }
  });
  // 👇🏾 Charger les tâches au démarrage de la page
  fetchTasks();
});
