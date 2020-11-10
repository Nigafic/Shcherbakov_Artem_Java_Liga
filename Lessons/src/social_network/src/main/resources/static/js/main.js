var userApi = Vue.resource("/users{/id}");

Vue.component ("user-row",{
    props: ['user'],
    template: '<div><i>({{ user.id }}) </i>{{ user.firstName }} {{ user.lastName }} {{ user.country }} {{ user.gender }} {{ user.age }}</div>'
});

Vue.component('users-list', {
    props: ['users'],
    template: '<div>'+
    '<user-row v-for = "user in users" :key="user.id" :user = "user" />'
    +'</div>',
    created: function() {
        userApi.get().then(result =>
            result.json().then(data =>
                data.forEach(user => this.users.push(user))
            )
        )
    }
    });

var app = new Vue({
  el: '#app',
  template: '<users-list :users ="users"/>',
  data: {
    users: [

    ]
  }
});