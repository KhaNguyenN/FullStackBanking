import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-saving',
  templateUrl: './saving.component.html',
  styleUrls: ['./saving.component.css']
})
export class SavingComponent implements OnInit {


  constructor() { }
  userid = "1"
  entered_amount: string ="amount"
  ngOnInit(): void {
  }

  async showSavings() { //async returns a promise (which fetch returns)
   let url="http://localhost:8080/FullStack_Banking/";
    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    
      let user = {
        id: this.userid
      }

      
    let response2 = await fetch(url + "selectSavingsById", {

      method: "POST",

      body: JSON.stringify(user),
     
      credentials: "include"
    });
    console.log(response2.status)
    console.log(JSON.stringify(user))

    //let response = await fetch(url + 'selectsavingsById', {credentials: "include"});

    console.log("Going into the tables");
    console.log(response2.status)
    
    if(response2.status === 200) { //if the request is successful...
        
        //console.log(response); //just to see what comes back for debug
        console.log("populating tables")
        let data = await response2.json(); //get the JSON data from the response, turn it into JS object
        

        //now, I want to put each avenger into my table
        for(let savings of data) { //for every avenger in the data variable/object
          
            console.log(savings); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = savings.id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            // cell2.innerHTML = savings.savingstransDate;
            cell2.innerHTML = "2021-08-04"
            row.appendChild(cell2);

            // let cell3 = document.createElement("td");
            // cell3.innerHTML = savings.savingstranstype;
            // row.appendChild(cell3);

            let cell3 = document.createElement("td");
            cell3.innerHTML = savings.savingstransdescription;
            row.appendChild(cell3);

            console.log(savings.savingstransdescription);

            let cell4 = document.createElement("td");
            cell4.innerHTML = savings.savingstransamount;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = savings.savingstranstotal;
            row.appendChild(cell5);

            // let cell7 = document.createElement("td");
            // cell7.innerHTML = savings.customerid;
            // row.appendChild(cell7);

            // //if the avenger has a home, just fill the cell with the home name
            // if(avenger.home_fk != null){
            //     console.log("home came through")
            //     let cell7 = document.createElement("td");
            //     cell7.innerHTML = avenger.home_fk.homeName;
            //     row.appendChild(cell7);
            // } else { //otherwise, still append the cell but leave it empty
            //     let cell7 = document.createElement("td");
            //     row.appendChild(cell7);
            // }



            
            document.getElementById("savingsBody")!.appendChild(row)
        }

    }

}

async submitSavings() {

  let url="http://localhost:8080/FullStack_Banking/";

  let user = {
    id: this.userid,
    amount: this.entered_amount
    
  }
  

  let response = await fetch(url + "savingsToChecking", {

    method: "POST",

    body: JSON.stringify(user),
   
    credentials: "include"
  });
}

async submitCredit() {

  let url="http://localhost:8080/FullStack_Banking/";

  let user = {
    id: this.userid,
    amount: this.entered_amount
    
  }
  

  let response = await fetch(url + "savingsToCredit", {

    method: "POST",

    body: JSON.stringify(user),
   
    credentials: "include"
  });
}
}


