import React from "react";
import { useState,useEffect } from "react";
let url="http://localhost:8080/employee";
function GetMethod(){
    let [data,setData]=useState([]);
    let urlFunction=async()=>{
        let urlCheck=await fetch(url);
        let jsonData=await urlCheck.json();
        console.log(jsonData);
        setData(jsonData);
    }
    useEffect(()=>{
        console.log(urlFunction());
    },[])
    return(
        <div>
            {data.map((ele)=>{
                return(
                    <div className="map-box" key={ele.id}>
                        <p>Employee ID:{ele.id}</p>
                        <br />
                        <p>Employee Name:{ele.name}</p>
                        <br />
                        <p>Employee Department:{ele.dname}</p>
                        <br />
                        <p>Employe Department Number:{ele.deptno}</p>
                        <br />
                        <p>Employee Email Id:{ele.email}</p>
                        <br />
                        <p>Employee Location:{ele.loc}</p>
                    </div>
                )
            })}
        </div>
    )
}
export default GetMethod;