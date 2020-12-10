import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";
// import handleDelete from "../../containers/HotelList";
// import handleEdit from "../../containers/HotelList";

const Hotel = (props) => {
const { id, namaHotel, alamat, nomorTelepon, handleEdit, handleDelete} = props;
return (
<div className={classes.hotel}>
 <h3>{`ID Hotel ${id}`}</h3>
 <p>{`Nama Hotel: ${namaHotel}`}</p>
 <p>{`Alamat: ${alamat}`}</p>
 <p>{`Nomor telepon: ${nomorTelepon}`}</p>
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