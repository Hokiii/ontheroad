const app = new Vue({
    el: '#app',
    data: {
        orderHotelFrom: {},
        orderFlightFrom: {},
        orderTrainFrom: {},
        orderCarFrom: {},
        hotProduction: [],
        cheapFlights: [
            {
                from: '北京',
                to: '青岛',
                imgUrl: 'assets/images/flights/1.png',
                price: 170
            },
            {
                from: '北京',
                to: '杭州',
                imgUrl: 'assets/images/flights/2.png',
                price: 190
            },
            {
                from: '北京',
                to: '大连',
                imgUrl: 'assets/images/flights/3.png',
                price: 210
            },
            {
                from: '北京',
                to: '上海',
                imgUrl: 'assets/images/flights/4.png',
                price: 235
            },
            {
                from: '北京',
                to: '重庆',
                imgUrl: 'assets/images/flights/5.png',
                price: 240
            },
            {
                from: '北京',
                to: '昆明',
                imgUrl: 'assets/images/flights/6.png',
                price: 280
            },
        ],
        hotCars: [
            {
                name: '荣威RX5新能源',
                seats: 5,
                price: 209,
                imgUrl: 'assets/images/cars/1.jpg'
            },
            {
                name: '北汽新能源EU',
                seats: 5,
                price: 299,
                imgUrl: 'assets/images/cars/2.jpg'
            },
            {
                name: '日产轩逸',
                seats: 5,
                price: 303,
                imgUrl: 'assets/images/cars/3.jpg'
            },
            {
                name: '大众高尔夫',
                seats: 5,
                price: 309,
                imgUrl: 'assets/images/cars/4.jpg'
            },
            {
                name: '北京现代ix35',
                seats: 5,
                price: 372,
                imgUrl: 'assets/images/cars/5.jpg'
            }
        ],
        hotArticles: {}
    },
    methods: {
        saveUserInfo() {
            console.log(this.loginForm);
            axios.post("http://localhost:8080/login", this.loginForm).then((res) => {
                console.log(res.data);
                console.log(res.data.state);
                if (res.data.state) {
                    console.log(res.data.msg);
                    location.href = './index.html';
                } else {
                    alert(res.data.msg);
                }
            })
        },
        getHotProduction() {
            console.log(this.hotProduction);
            const that = this;
            axios.get("http://localhost:8080/index").then((res) => {
                console.log(res.data);
                this.hotProduction = res.data;
                console.log(this.hotProduction);
            });
        }
    },
    mounted () {
        this.getHotProduction();
    }
})
