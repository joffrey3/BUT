import model from './model'
import Controller from './controller'
import View from './view'

const view = new View()
const app = new Controller(view,model)

