import axios from 'axios'

const INSTRUCTOR = 'rewardTest'
const COURSE_API_URL = 'http://localhost:8080'
const INSTRUCTOR_API_URL = `${COURSE_API_URL}/instructors/${INSTRUCTOR}`

class DataService {

    retrieveAllCustomers(name) {
        //console.log('executed service')
        return axios.get(`${INSTRUCTOR_API_URL}/customers`);
    }

    retrieveCustomer(name, id) {
        //console.log('executed service')
        return axios.get(`${INSTRUCTOR_API_URL}/customers/${id}`);
    }

    deleteCustomer(name, id) {
        //console.log('executed service')
        return axios.delete(`${INSTRUCTOR_API_URL}/customers/${id}`);
    }

    updateCustomer(name, id, transAmount) {
        //console.log('executed service')
        return axios.put(`${INSTRUCTOR_API_URL}/customers/${id}`, transAmount);
    }

    createPurchase(product, transAmount) {
        //console.log('executed service')
        return axios.post(`${INSTRUCTOR_API_URL}/customers/`, transAmount);
    }
}

export default new DataService()