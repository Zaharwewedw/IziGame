
fetch('api/person')
    .then(response => response.json())
    .then(data => {
        const personList = document.getElementById('person-list');
        data.forEach(person => {
            const li = document.createElement('li');
            li.textContent = `${person.id} ${person.name} ${person.email}`;
            personList.appendChild(li);
        });
    })
    .catch(error => console.error('Ошибка:', error));


fetch('http://localhost:8082/api/game')
    .then(response => response.json())
    .then(data => {
        const gameList = document.getElementById('game-list');
        data.forEach(game => {
            const li = document.createElement('li');
            li.textContent = `${game.id} ${game.name} ${game.genre}`;
            gameList.appendChild(li);
        });
    })
    .catch(error => console.error('Ошибка:', error));
