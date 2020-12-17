import React from "react";
import classes from "./styles.module.css";
import ReactDOM from "react-dom";
import Button from "../../components/Button";

const Hotel = (props) => {
  const {
    id,
    namaHotel,
    alamat,
    nomorTelepon,
    listKamar,
    handleEdit,
    handleDelete,
  } = props;
  // const kamarz = listKamar.length();
  return (
    <div className={classes.hotel}>
      <h3>{`ID Hotel ${id}`}</h3>
      <p>{`Nama Hotel: ${namaHotel}`}</p>
      <p>{`Alamat: ${alamat}`}</p>
      <p>{`Nomor telepon: ${nomorTelepon}`}</p>

      <p>{`List Kamar: `}</p>

      {listKamar.length !== 0 ? (
        listKamar.map((obj) => {
          return (
            <span
              key={`${obj.id}`}
              style={{
                marginLeft: ".5rem",
                borderRadius: "20px 20px 20px 20px",
                background: "#3C50C2",
                color: "white",
              }}
            >
              &nbsp;&nbsp;&nbsp;
              <strong>
                {obj.namaKamar} ({obj.kapasitasKamar})
              </strong>
              &nbsp;&nbsp;
              <span>{"  "}</span>
              <span> </span>
              <span> </span>
            </span>
          );
        })
      ) : (
        <p>
          <strong>{`gada kamarnya`}</strong>
        </p>
      )}

      <p></p>
      <Button onClick={handleEdit} variant="success">
        Edit
      </Button>
      <Button onClick={handleDelete} variant="danger">
        Delete
      </Button>
    </div>
  );
};
export default Hotel;
