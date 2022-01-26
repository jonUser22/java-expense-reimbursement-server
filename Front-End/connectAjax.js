const baseUrl = "http://localhost:8082/java-expense-reimbursement-server";
const itemsUrl = baseUrl + "/login";
const userUrl = baseUrl + "/users";

const viewPendingUrl = baseUrl + "/pending";
const viewResolvedUrl = baseUrl + "/resolved";
const managerViewPendingUrl = baseUrl + "/allPending";




function performAjaxGetRequest(url, callback){
const xhr = new XMLHttpRequest();
xhr.open("GET", url);
xhr.onreadystatechange = function(){
    if(xhr.readyState==4){
        if(xhr.status==200){
            callback(xhr.response); // this is going to be the response body of our http response  (JSON)
        } else {
            console.error("something went wrong with our GET request to "+url);
        }
    } 
}
xhr.send();
}


function performAjaxPostRequest(url, payload, successCallback, failureCallback){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 ){
            if(xhr.status>199 && xhr.status<300){
                successCallback(xhr.response); // this is going to be the response body of our http response  (JSON)
            } else {
                if(failureCallback){
                    failureCallback()
                } else{
                    console.error("An error occurred while attempting to create a new record")
                }
            }
        }
    }
    xhr.send(payload);
}


function getUserById(id, callback){
    performAjaxGetRequest((userUrl + "?id="+id), callback);
 
}

//Employee view all pending requests
function viewEmpPendingRequest(employee_Id, callback){

    performAjaxGetRequest((viewPendingUrl + "?id="+employee_Id), callback);

}
//Employee view all resolved requests
function viewEmpResolvedRequest(employee_Id, callback){

    performAjaxGetRequest((viewResolvedUrl + "?id="+employee_Id), callback);

}

//Manager can view all employee pending requests
function viewAllPendingRequest(employee_Id, callback){

    performAjaxGetRequest((managerViewPendingUrl  +"?id="+employee_Id), callback);
}