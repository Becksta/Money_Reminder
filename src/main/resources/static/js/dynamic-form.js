const app = Vue.createApp({});

app.component('dynamic-form', {
    template: `

        <div>
      <input v-model="nameField" placeholder="Name" type="text" ref="nameInput">
      <input v-model="emailField" placeholder="Email" type="text" ref="emailInput">
      <input v-model="owesField" placeholder="Schulden" @keyup.enter="save()">
      <button type="button" @click="save()">Save</button>
    </div>
     <div>
      <h3> {{ title }} </h3>
        <table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Email-Adresse</th>
            <th>Schulden</th>
          </tr>
          </thead>
          <tr>
            <td>{{ nameField }}</td>
            <td>{{ emailField }}</td>
            <td>{{ owesField }}</td>
          </tr>
          </tbody>
        </table>
    </div>
  `,
    data() {
        return {
            nameField: '',
            emailField: '',
            owesField: '',

        };
    },
    methods: {
        save() {
            axios
                .post('/rest/friends', {
                    name: this.nameField,
                    email: this.emailField,
                    owes: this.owesField,
                });
        },
    },
});

app.mount('#dynamic-form');
