import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class BankAccount {
    val _balance: AtomicInteger = AtomicInteger(0)
    val isOpen = AtomicBoolean(true)

    val balance: Int
        get() = if (!isOpen.get()) {
            throw IllegalStateException()
        } else {
            _balance.get()
        }

    fun adjustBalance(amount: Int){
        if (!isOpen.get())
            throw IllegalStateException()
        _balance.addAndGet(amount)
    }

    fun close() {
        isOpen.set(false)
    }
}
