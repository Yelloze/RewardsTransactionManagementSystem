import React, { Component } from 'react'
import DataService from '../service/DataService';

const INSTRUCTOR = 'rewardTest'

class ListCustomerComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            customers: [],
            message: null
        }
        this.deleteCustomerClicked = this.deleteCustomerClicked.bind(this)
        this.refreshCustomer = this.refreshCustomer.bind(this)
    }

    componentDidMount() {
        this.refreshCustomer();
    }

    refreshCustomer() {
        DataService.retrieveAllCustomers(INSTRUCTOR)//HARDCODED
            .then(
                response => {
                    //console.log(response);
                    this.setState({ customers: response.data })
                }
            )
    }

    deleteCustomerClicked(id) {
        DataService.deleteCustomer(INSTRUCTOR, id)
            .then(
                response => {
                    this.setState({ message: `Delete of course ${id} Successful` })
                    this.refreshCustomer()
                }
            )

    }


    render() {
        console.log('render')
        return (
            <div className="container">
                <h3>All Customers</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Product</th>
                                <th>Transaction Amount</th>
                                <th>Rewards</th>

                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.customers.map(
                                    customer =>
                                        <tr key={customer.id}>
                                            <td>{customer.id}</td>
                                            <td>{customer.product}</td>
                                            <td>{customer.transAmount}</td>
                                              <td>{customer.rewards}</td>

                                            <td><button className="btn btn-success">Rewards</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteCustomerClicked(customer.id)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success">Search Transaction Id</button>
                        <input type="text" value=""/>
                        <button className="btn btn-success">Go</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListCustomerComponent