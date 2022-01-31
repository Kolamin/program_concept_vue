import axios from 'axios'

const EMPLOYEE_API_BASE_URL = 'http://localhost:8081/iquestion';

class EventService{

    getIQuestions(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
}

export default new EventService();