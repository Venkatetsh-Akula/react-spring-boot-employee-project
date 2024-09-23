import React, { useState } from "react";
let url="http://localhost:8080/employee";
function UpdateEmployee(){
    let [id,setId]=useState(0);
    let [name,setName]=useState("");
    let [dname,setDname]=useState("");
    let [deptno,setDeptno]=useState(0);
    let [email,setEmail]=useState("");
    let [loc,setLoc]=useState("")

    let employeeData=()=>{
        return{
            id:id,
            name:name,
            dname:dname,
            deptno:deptno,
            email:email,
            loc:loc
        };
    }


    let submitData=async(e)=>{
        e.preventDefault();
        try{
            let urlData= await fetch(`${url}/${id}`,{
                method:"PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(employeeData()),
            })
            if(urlData.ok){
                console.log("code Excuted succcessfully");
            }
            else{
                console.error("Some thing went wrong");
            }
        }catch(error){
            console.error(error);
        }
    }


    return(
        <div className="update-component">
                <div className="update-form">
                    <form onSubmit={submitData}>
                        <label>Enter Employee ID: <br />
                            <input type="number" name="id" onChange={(e)=>{setId(e.target.value)}}/>
                        </label> <br />
                        <label >Enter the Employee Name: <br />
                            <input type="text" name="name" onChange={(e)=>{setName(e.target.value)}}/>
                        </label> <br />
                        <label >Enter Department Name <br />
                            <input type="text" name="dname" onChange={(e)=>{setDname(e.target.value)}}/>
                        </label> <br />
                        <label >Enter Department Number: <br />
                            <input type="number" name="deptno" onChange={(e)=>{setDeptno(e.target.value)}}/>
                        </label> <br />
                        <label >Enter Employee Email: <br />
                            <input type="text" name="email" onChange={(e)=>{setEmail(e.target.value)}}/>
                        </label> <br />
                        <label >Enter Employee Location: <br />
                            <input type="text" name="loc"  onChange={(e)=>{setLoc(e.target.value)}}/>
                        </label> <br />
                        <button type="submit">Submit</button>
                    </form>
                </div>
        </div>
    )
}
export default UpdateEmployee;