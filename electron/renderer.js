// This file is required by the index.html file and will
// be executed in the renderer process for that window.
// No Node.js APIs are available in this process because
// `nodeIntegration` is turned off. Use `preload.js` to
// selectively enable features needed in the rendering
// process.

const fs = require('fs');

document.getElementById("load").addEventListener("click", myFunction);

function myFunction(){
var selectedFile = document.getElementById('input').files[0];

fs.readFile('Romeo_and_Juliet.xml', (err, data) => {
  if (err) {
    console.error(err)
    return
  }
  console.log(data)


               //readXml=e.target.result;

               var parser = new DOMParser();
               var doc = parser.parseFromString(data, "application/xml");

			   document.getElementById('source').value = data;
			   

				let els = doc.querySelectorAll('*');

var counter = 0;
						els.forEach(function(element) {

							console.log(element.tagName);
						  element.classList.add(element.tagName);

					if (element.getElementsByTagName("*").length>0){
				var new_element = doc.createElement('div');
					}else{
				var new_element = doc.createElement('p');
					}
				var	old_attributes = element.attributes;
				var	new_attributes = new_element.attributes;

				// copy attributes
				for(var i = 0, len = old_attributes.length; i < len; i++) {
					new_attributes.setNamedItem(old_attributes.item(i).cloneNode());
				}
				
// copy child nodes
				do {
					new_element.appendChild(element.firstChild);
					
				} 
				while(element.firstChild);

				// replace element
				
				element.parentNode.replaceChild(new_element, element);


						  counter++;

						});
			   console.log(counter);
			   document.getElementById('dest').value =  (new XMLSerializer()).serializeToString(doc);
			   })
           }
           
	