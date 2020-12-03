import React from "react";

export default function Emptystate(props) {
    
    return(
        <div className = "col-sm">
            <h3 className = "text-center">
                Belum ada item yang dipilih
            </h3>
            <p className = "text-center">
                Klik salah satu item di List Movies
            </p>
        </div>
    );
}

const styles = {
    heading : {
        fontFamily: "courier-new"
    }
};