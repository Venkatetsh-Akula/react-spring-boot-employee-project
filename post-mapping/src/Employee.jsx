import React, { useState } from "react";
function Employee(){
    const url="http://localhost:8080/employee";
    const[name,setName]=useState("");
    const[dname,setDname]=useState("");
    const[deptno,setDeptno]=useState(-1);
    const[email,setEmail]=useState("")
    const[loc,setLoc]=useState("");
    let oneClickData=()=>{
            return{
                name:name,
                dname:dname,
                deptno:deptno,
                email:email,
                loc:loc
            }
    }

    
    let saveEmployee=async (e)=>{
        e.preventDefault();
        try{
            let urlData=await fetch(url,{
                method:"POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(oneClickData())
            })
            if(urlData.ok){
                let result=await urlData.json();
                console.log(result);
            }else{
                console.log("error")
            }
        }
        catch(error){
            console.error(error);
        }
      }
    return(
        <div className="employee-component">
            <div className="employee-form">
                <form onSubmit={saveEmployee}>
                    <label >Enter Employee Name: <br />
                        <input type="text" name="name" onChange={(e)=>{setName(e.target.value)}}/>
                    </label> <br />
                    <label >Enter Employee Department Name  <br /> 
                        <input type="text" name="dname" onChange={(e)=>{setDname(e.target.value)}}/>
                    </label><br />
                    <label >Enter Employee Department number <br />
                        <input type="number" name="deptno" onChange={(e)=>{setDeptno(e.target.value)}}/>
                    </label> <br />
                    <label>Enter Employee Email Id <br />
                        <input type="text" name="email" onChange={(e)=>{setEmail(e.target.value)}}/>
                    </label> <br />
                    <label >Enter Employee Location <br />
                        <input type="text" name="loc" onChange={(e)=>{setLoc(e.target.value)}}/>
                    </label> <br />
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
    )
}
export default Employee;