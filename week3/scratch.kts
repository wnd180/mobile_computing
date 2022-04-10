import kotlin.collections.ArrayList

class MaxHeap(){
    lateinit var temp_arr:ArrayList<Int>
    fun push(element:Int){
        temp_arr.add(element)
    }
    fun pop(): Int {
        var temp = temp_arr[0]
        temp_arr.remove(0)
        return temp
    }
}
fun test(){
    var random_arr=arrayListOf<Int>()
    var my_arr=arrayListOf<Int>()
    for(i in 1..1000){
        random_arr.add((Math.random()*1000).toInt())
    }
    random_arr.sort()
    var maxheap = MaxHeap()
    for(i in 1..random_arr.size){
        maxheap.push(random_arr[i])
    }
    for(i in 1..random_arr.size){
        if (maxheap.pop().equals(random_arr[i])){
        }else{
            println("error")
            break
        }
    }

}
test()