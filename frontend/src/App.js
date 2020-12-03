import React from "react";

import List from "components/List";
import Emptystate from "./components/EmptyState";
import listMovies from "movies.json";
import "./App.css";
import Item from "components/Item";

export default class App extends React.Component {
  state = {
    favItems: [],
  };

  noState ={
    favItems: [],
  };

  hideFav = true;

  handleItemClick = (item) => {

    const newItems = [ ... this.state.favItems];
    const newItem = { ... item};

    const targetInd = newItems.findIndex((it) => it.id == newItem.id);

    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd,1);

    this.setState({ favItems: newItems});

  }

  handleItemClickList = (item) => {

    const newItems = [ ... this.state.favItems];
    const newItem = { ... item};

    const targetInd = newItems.findIndex((it) => it.id == newItem.id);

    if (targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems});

  }

  deleteItemClick = () => {


    this.setState(this.noState);

  }

  hideFavorite = () => {
    this.hideFav = !this.hideFav;
    this.setState({  });
  };

  render(){
    const{favItems}=this.state;

    return(
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="text-center">
         <label className="switch">
              <input type="checkbox" onClick={this.hideFavorite} />
              <span className="slider round"></span>
            </label>
            <span> <strong>Show Favorites</strong></span>
        </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClickList}
              />
            </div>
            {this.hideFav === false &&
                <div className = "col-sm">
                    {favItems.length > 0 &&
                        <div className = "col-sm">
                            <List 
                                title = "My Favorite"
                                items = {favItems}
                                onItemClick = {this.handleItemClick}
                            />
                            {favItems.length > 0
        ? <button type="button" class="btn btn-danger" onClick={this.deleteItemClick}>Delete All</button>
        : null
      }        
                        </div>
                    }
                    {favItems.length <= 0 &&
                        <Emptystate />
                    }
                </div>
            }
          </div>
        </div>
      </div>

    );
  }
}