import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
    state: () => ({
      token: null,
      username: ''
    }),
    actions: {
      login(token, username) {
        this.token = token
        this.username = username
      },
      logout() {
        this.token = null
        this.username = ''
      }
    }
  })
  