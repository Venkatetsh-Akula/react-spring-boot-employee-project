import React, { useState } from "react";
let url="http://localhost:8080/employee";
function DeleteID(){
    const[id,SetId]=useState(0);
    let EmployeeId=()=>{
        console.log(id);
        return id;
    }
    let close=async(e)=>{
        e.preventDefault();
        try{
            let urlData=await fetch(`${url}/${EmployeeId()}`,{
                method:"DELETE",
            })
            if(urlData.ok){
                let dataJson=urlData.json();
                console.log(dataJson);
                document.writeln("Deleted Successfuly ",id);
                console.log("Deleted Link Activated")
            }else{
                console.error("No Delete is activated");
            }
        }
        catch(error){
            console.error(error);
        }
    }
    return(
        <div className="delete-component">
            <div className="delete-form">
                <form onSubmit={close}>
                    <label>
                        Enter the Employee ID Delete: <br />
                        <input type="number" name="id" onChange={(e)=>{SetId(e.target.value)}}/> <br />
                        <button type="submit">Submit</button>
                    </label>
                </form>
            </div>
        </div>
    )
}
export default DeleteID;