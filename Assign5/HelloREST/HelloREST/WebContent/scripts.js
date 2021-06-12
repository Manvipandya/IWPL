const app = document.getElementById('root');
const container = document.createElement('div');
container.setAttribute('class', 'container');

app.appendChild(container);

var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8080/HelloREST/rest/bonjour/blooddonor', true);
request.onload = function () {

  var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
    data.forEach(blooddonors => {
      console.log(blooddonors.name,blooddonors.type,blooddonors.age,blooddonors.rate)
      
      const card = document.createElement('div')
      /*card.setAttribute('class', 'card')*/

      const h1 = document.createElement('h1')
      h1.textContent = blooddonors.name

      const p = document.createElement('p')
      p.textContent = `Manufacturer : ${blooddonors.type} `
    	  
	  const q = document.createElement('p')
      q.textContent = `Price : ${blooddonors.age} `
    	  
	  const r = document.createElement('p')
      r.textContent = `RAM : ${blooddonors.rate}`
      

      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(p)
      card.appendChild(q)
      card.appendChild(r)
      
    });
  } else {
    const errorMessage = document.createElement('marquee');
    errorMessage.textContent = `It's not working!`;
    app.appendChild(errorMessage);
  }
}
request.send();