import React, { Component } from 'react';
import ListCustomerComponent from './ListCustomerComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import CustomerComponent from './CustomerComponent';

class InstructorApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h1>Rewards Transaction Management Application</h1>
                    <Switch>
                        <Route path="/" exact component={ListCustomerComponent} />
                        <Route path="/customer" exact component={ListCustomerComponent} />
                        <Route path="/customer/:id" component={CustomerComponent} />
                    </Switch>
                </>
            </Router>
        )
    }
}

export default InstructorApp