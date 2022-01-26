
document.getElementById("reimbursementRequestEmpBtu").addEventListener("click", submitReimbursmentRequest);
document.getElementById("viewPendRequestEmpBtu").addEventListener("click", viewPendingReimbursmentRequests);
document.getElementById("viewResolvedRequestEmpBtu").addEventListener("click", viewResolvedReimbursmentRequests);
document.getElementById("logOutEmpBtu").addEventListener("click", employeeLogout);


function submitReimbursmentRequest(){

   const token = sessionStorage.getItem("token");
   const parsedToken = token.split(":");
   const employee_Id = parsedToken[0];

   
   let discription = document.getElementById("employee_discription_input").value;
   let amount = document.getElementById("reimbursement_amount_requested").value;

   let ReimbursmentRequest = {employee_Id, discription, amount};
   
   const submitReiburUrl =  baseUrl + "/subReqR";
   performAjaxPostRequest(submitReiburUrl, JSON.stringify(ReimbursmentRequest), handleSuccessfulRequest, handleUnsuccessfulRequest);
 }
 
 function handleSuccessfulRequest(userJSON){
   console.log("Reimbursment Request has been submitted");

   const res = JSON.parse(userJSON);
   document.getElementById("reimbursmentReq").innerText = "Request complete: "+
   "Request Number: [" + res.request_num + "] Employee_Id: [" + res.employee_Id + "] Discription: [" 
   + res.discription + "] Amount: [" + res.amount + "] Status: [" + res.status + "]";

   document.getElementById("error-msg").hidden = true;
 }
 
 function handleUnsuccessfulRequest(){
   console.log("Reimbursment Request unsuccessful");
   document.getElementById("error-msg").hidden = false;
 }

function employeeLogout(){
   window.close();

}




function viewPendingReimbursmentRequests(){

   const token = sessionStorage.getItem("token");
   const parsedToken = token.split(":");
   const employee_Id = parsedToken[0];
   
   viewEmpPendingRequest(employee_Id, function(usersJSON){
    const pending = JSON.parse(usersJSON);
    console.log("Pending reimbursment request has been submitted");

   // let temp = "";

  //   for (let pen of pending){

     //   temp = temp + pending[pen] + " ";
     
  //   }

     //need a loop to display all results
     document.getElementById("viewPendingReq").innerText = "request_num: [" + pending.request_num
     +"] discription: ["+ pending.discription+"] amount: [" + pending.amount 
     + "] status: [" + pending.status + "]";
   
   });}
   
   

   function viewResolvedReimbursmentRequests(){
   
      const token = sessionStorage.getItem("token")
      const parsedToken = token.split(":");
      const employee_Id = parsedToken[0];
      
      viewEmpResolvedRequest(employee_Id, function(usersJSON){
       const resolved = JSON.parse(usersJSON);
       console.log("Resolved reimbursment request has been submitted");


     
   
       //need a loop to display all results
       document.getElementById("viewResolvedReq").innerText = "request_num: [" + resolved.request_num
        +"] discription: ["+ resolved.discription+"] amount: ["
        + resolved.amount + "] status: [" + resolved.status + "]";
      
      });}
      
  