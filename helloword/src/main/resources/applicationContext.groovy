import hello.Hello
import hello.HelloImpl
import hello.HelloPerson

beans {
    hello(HelloImpl) {
    }
    helloPerson(HelloPerson, name) {
        name = '허윤호'
    }
}