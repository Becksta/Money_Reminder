import {mount} from '@vue/test-utils'
import app from './dynamic-form'

describe('app', () => {
    it('renders a message and responds correctly to user input', () => {
        const wrapper = mount(app, {
            data() {
                return {
                    name: 'Leon',

                }
            }
        })

        // see if the message renders
        expect(wrapper.find('.name').text()).toEqual('Leon')

    })
})