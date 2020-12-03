import React from "react";

import List from "components/List";
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

  render(){
    const{favItems}=this.state;

    return(
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClickList}
              />
            </div>
            <div className="col-sm">
              <div className=""></div>

<List
              title="My Favorites"
              items={favItems}
              onItemClick={this.handleItemClick}
              
              />
               {favItems.length > 0
        ? <button type="button" class="btn btn-danger" onClick={this.deleteItemClick}>Delete All</button>
        : null
      }
                 
        
              
            </div>
            
          </div>
        </div>
      </div>

    );
  }
}