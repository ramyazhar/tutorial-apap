import React, { Component } from "react";
import Hotel from "../../components/Hotel";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class HotelList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      hotels: [],
      isLoading: false,
      isCreate: false,
      isEdit: false,
      search: "",
      namaHotel: "",
      alamat: "",
      nomorTelepon: "",
      currentPage: 1,
      hotelsPerPage: 5,
      upperPageBound: 3,
      lowerPageBound: 0,
    };
    // this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddHotel = this.handleAddHotel.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
    this.handleEditHotel = this.handleEditHotel.bind(this);
    this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
    this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  updateSearch(event) {
    this.setState({
      search: event.target.value.substr(0, 20),
    });
  }

  handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
  }

  handleClick(event) {
    this.setState({
      currentPage: Number(event.target.id),
    });
  }

  handleAddHotel() {
    this.setState({ isCreate: true });
  }

  handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false });
  }

  handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  }
  handleEditHotel(hotel) {
    this.setState({
      isEdit: true,
      id: hotel.id,
      namaHotel: hotel.namaHotel,
      alamat: hotel.alamat,
      nomorTelepon: hotel.nomorTelepon,
    });
  }

  componentDidMount() {
    this.loadData();
  }
  async loadData() {
    try {
      const { data } = await APIConfig.get("/hotels");
      this.setState({ hotels: data });
      console.log(data);
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  async handleSubmitAddHotel(event) {
    event.preventDefault();
    try {
      const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
      };
      await APIConfig.post("/hotel", data);
      this.loadData();
      this.setState({
        namaHotel: "",
        alamat: "",
        nomorTelepon: "",
      });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  async handleSubmitEditHotel(event) {
    event.preventDefault();
    try {
      const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
      };
      await APIConfig.put(`/hotel/${this.state.id}`, data);
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  async handleDeleteHotel(id) {
    try {
      await APIConfig.delete(`/hotel/${id}`);
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  render() {
    let filteredHotel = this.state.hotels.filter((hotel) => {
      return (
        hotel.namaHotel
          .toLowerCase()
          .indexOf(this.state.search.toLowerCase()) !== -1
      );
    });

    const {
      currentPage,
      hotelsPerPage,
      upperPageBound,
      lowerPageBound,
    } = this.state;

    const indexOfLastTodo = currentPage * hotelsPerPage;
    const indexOfFirstTodo = indexOfLastTodo - hotelsPerPage;
    const currentHotels = filteredHotel.slice(
      indexOfFirstTodo,
      indexOfLastTodo
    );

    const renderHotels = currentHotels.map((hotel) => {
      return (
        <Hotel
          key={hotel.id}
          id={hotel.id}
          namaHotel={hotel.namaHotel}
          alamat={hotel.alamat}
          nomorTelepon={hotel.nomorTelepon}
          listKamar={hotel.listKamar}
          handleEdit={() => this.handleEditHotel(hotel)}
          handleDelete={() => this.handleDeleteHotel(hotel.id)}
        />
      );
    });

    const pageNumbers = [];
    for (let i = 1; i <= Math.ceil(filteredHotel.length / hotelsPerPage); i++) {
      pageNumbers.push(i);
    }

    const renderPageNumbers = pageNumbers.map((number) => {
      if (number === 1 && currentPage === 1) {
        return (
          <a key={number} id={number}>
            <a href="#" id={number} onClick={this.handleClick}>
              {" "}
              {number}{" "}
            </a>
          </a>
        );
      } else if (number < upperPageBound + 1 && number > lowerPageBound) {
        return (
          <a key={number} id={number}>
            <a href="#" id={number} onClick={this.handleClick}>
              {" "}
              {number}{" "}
            </a>
          </a>
        );
      }
    });

    return (
      <div className={classes.hotelList}>
        <h1 className={classes.title}>All Hotels</h1>
        <Button onClick={this.handleAddHotel} variant="primary">
          Add Hotel
        </Button>
        <div>
          <div>Cari Hotel</div>
          <input
            type="text "
            value={this.state.search}
            onChange={this.updateSearch.bind(this)}
          />
        </div>
        <div className={classes.Hotels}>{renderHotels}</div>
        <div>
          <ul id="page-numbers">{renderPageNumbers}</ul>
        </div>

        <Modal
          show={this.state.isCreate || this.state.isEdit}
          handleCloseModal={this.handleCancel}
        >
          <form>
            <h3 className={classes.modalTitle}>
              {this.state.isCreate
                ? "Add Hotel"
                : `Edit Hotel Nomor ${this.state.id}`}
            </h3>
            <input
              className={classes.textField}
              type="text"
              placeholder="Nama Hotel"
              name="namaHotel"
              value={this.state.namaHotel}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="text"
              placeholder="Alamat"
              name="alamat"
              value={this.state.alamat}
              onChange={this.handleChangeField}
            />
            <textarea
              className={classes.textField}
              placeholder="Nomor Telepon"
              name="nomorTelepon"
              rows="4"
              value={this.state.nomorTelepon}
              onChange={this.handleChangeField}
            />
            <Button
              onClick={
                this.state.isCreate
                  ? this.handleSubmitAddHotel
                  : this.handleSubmitEditHotel
              }
              variant="primary"
            >
              {this.state.isCreate ? "Create" : "Edit"}
            </Button>
            <Button onClick={this.handleCancel} variant="danger">
              Cancel
            </Button>
          </form>
        </Modal>
      </div>
    );
  }
}
export default HotelList;
