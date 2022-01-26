document.getElementById("approveDenyRequestBtu").addEventListener("click", submitApproveDenyRequest);
document.getElementById("viewAllPendRequestEmpBtu").addEventListener("click", viewAllPendingReimbursmentRequests);
document.getElementById("logOutManBtu").addEventListener("click", managerLogout);


function submitApproveDenyRequest(){

   let request_num = document.getElementById("manager_input").value;
   let status = document.getElementById("status_update").value;

   let ApproveDenyRequest = {request_num, status};
   
   const ApproveDenyUrl =  baseUrl + "/reqApproval";
   performAjaxPostRequest(ApproveDenyUrl, JSON.stringify(ApproveDenyRequest), 
   handleSuccessfulRequest, handleUnsuccessfulRequest);
 }
 
 function handleSuccessfulRequest(userJSON){
   console.log("Employee status update has been submitted");
   //const res = JSON.parse(userJSON);
   document.getElementById("ApproveDenyReq").innerText = "Reimbursement updated: "
   document.getElementById("error-msg").hidden = true;
 }
 
 function handleUnsuccessfulRequest(){
   console.log("Employee status update unsuccessful");
   document.getElementById("error-msg").hidden = false;
 }


 function managerLogout(){
    window.close();
 
 }
 





function viewAllPendingReimbursmentRequests(){

    const token = sessionStorage.getItem("token");
    const parsedToken = token.split(":");
    const employee_Id = parsedToken[0];
    
    viewAllPendingRequest(employee_Id, function(usersJSON){
    const allRequests = JSON.parse(usersJSON);
    console.log("View all Pending Request has been submitted");


    for (let res in  allRequests){

       console.log(res);

    }

     //need a loop to display all results
     document.getElementById("allPendingReq").innerText = "request_num: [" + allRequests.request_num 
     +"] discription: ["+ allRequests.discription+"] amount: [" + allRequests.amount 
     + "] status: [" + allRequests.status + "]";
    
});
}