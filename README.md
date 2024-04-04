#### Architecture Pattern 
Architectural patterns provide a structured approach for organizing code and separating concerns, making it easier to manage complexity and promote code reusability.

__Why does your app need good architecture?__
A simple answer is that everything should be organized in a proper way. So, the project becomes easily testable, scalable, manageable, robust and modular.  
`If we don’t use a right architecture pattern to build our project, we will face many issues such as-`
- __Difficult to test -__ Since large codes are unorganized so it’s difficult to completely test any single component.
- __Difficult to maintain -__ Unorganized code make difficult to keep track of the methods inside a class which makes difficult to improve or maintain it.
- __Difficult to scale -__ Unorganized code doesn’t have proper modularity which makes difficult to understand the existing features and add new features to it.

##### There are 3 architecture pattern to organize our code
- [Model view controller](https://github.com/riteshpandey5102/MVC-Demo)
- [Model view presenter](https://github.com/riteshpandey5102/MVP-Demo)
- [Model view viewmodel](https://github.com/riteshpandey5102/MVVM-Demo)

In this project we will learn about the first pattern Model view presenter   
### Model View Presenter
In this architecture pattern we divide our project in 3 layers  
__Model:__ The model layer is only responsible for storing and retrieving data. It doesn’t notify the presenter it only returns the data. So, it is not depended on presenter.  
__View:__ This layer is used to display the data on UI and handle user inputs. Here it doesn’t apply any logic on data to transform it into required format like we did in MVC. Also, it gets data directly from presenter. So, it is not depended on model it is only depended on presenter.  
__Presenter:__ It is used as mediator between model and view it simply gets the data from model and return it to view and take input from view and process it with model. It also applies the logic to transform the data in required format.  
![Model View Presenter](https://github.com/riteshpandey5102/MVP-Demo/blob/main/MVP.jpg?raw=true)
#### Problems in MVP
- In this Presenter is depended on view and view is depended on presenter which the which doesn’t make clear separation of code so it’s difficult to test and maintain it.
- If changes occur in view also need to modify presenter and if changes occur in presenter also need to modify view.
- It increases boilerplate code as each view required separate presenter interface.
- It is not lifecycle aware so need to manually handle data on Lifecyle changes.
- Presenter is not reusable

##### More Links
##### [Model view controller](https://github.com/riteshpandey5102/MVC-Demo)
##### [Model view viewmodel](https://github.com/riteshpandey5102/MVVM-Demo)

