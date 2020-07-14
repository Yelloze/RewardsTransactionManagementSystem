import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import DataService from '../service/DataService';

const INSTRUCTOR = 'rewardTest'


class CustomerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            product: '',
            transAmount : '',
            rewards : ''
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }

    componentDidMount() {

        console.log(this.state.id)

        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }

        DataService.retrieveCustomer(INSTRUCTOR, this.state.id)
            .then(response => this.setState({
                product: response.data.transAmount,
                transAmount: response.data.reward,
                reward:response.data.transAmount

            }))
    }

    render() {

        let { product, id,transAmount ,rewards} = this.state

        return (
            <div>
                <h3>Cusomers</h3>
                <div className="container">
                    <Formik
                        initialValues={{ id, product,transAmount,rewards}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}>

                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="product" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Product</label>
                                        <Field className="form-control" type="text" name="product" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Transaction Amount</label>
                                        <Field className="form-control" type="text" name="product" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Reward</label>
                                        <Field className="form-control" type="text" name="reward" />
                                    </fieldset>

                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
}

export default CustomerComponent