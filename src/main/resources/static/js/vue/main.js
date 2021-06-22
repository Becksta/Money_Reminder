new Vue({
    el: '#table',
    data () {
        return {
            keyword: '',
            dataArray: [
                { firstname: 'John', lastname: 'Doe', email: 'johndoe@example.com'  },
                { firstname: 'Jane', lastname: 'Doe', email: 'janedoe@example.com'  },
                { firstname: 'John', lastname: 'Doo', email: 'johndoo@example.com'  },
                { firstname: 'Jane', lastname: 'Doo', email: 'janedoo@example.com'  }
            ],
            fields: [
                {key: 'firstname', label: 'First name', sortable: true},
                {key: 'lastname', label: 'Last name', sortable: true},
                {key: 'email', label: 'Email', sortable: true}
            ]
        }
    },
    computed: {
        items () {
            return this.keyword
                ? this.dataArray.filter(item => item.firstname.includes(this.keyword) || item.lastname.includes(this.keyword) || item.email.includes(this.keyword))
                : this.dataArray
        }
    }
})