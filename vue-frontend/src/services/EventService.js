// import axios from 'axios'
//
// const EMPLOYEE_API_BASE_URL = 'http://localhost:8081/iquestion';
//
// class EventService{
//
//     getIQuestions(){
//         return axios.get(EMPLOYEE_API_BASE_URL);
//     }
// }
//
// export default new EventService();

import axios from 'axios'

const apiClient = axios.create({
    baseURL: `http://localhost:8081`,
    withCredentials: false, // This is the default
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
    }
})

export default {
    getEvents() {
        return apiClient.get('/iquestion')
    },
    getEvent(id) {
        return apiClient.get('/iquestion/' + id)
    }
}
