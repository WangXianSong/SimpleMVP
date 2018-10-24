# SimpleMVP

这是一个MVP模式的Demo

### 实现效果


![登录MVP](https://github.com/WangXianSong/SimpleMVP/blob/master/MVP1.gif)

![请求MVP](https://github.com/WangXianSong/SimpleMVP/blob/master/MVP2.gif)


  
![MVC MVP MVVM结构](https://i.imgur.com/fFVwl5e.png)

### 如何理解 MVC

MVC，全称是 Model-View-Controller，是一种软件设计典范，用一种业务逻辑、数据、界面显示分离的方法组织代码，在改进和个性化定制界面及用户交互的同时，不需要重新编写业务逻辑。其中Model层处理数据，业务逻辑等；View层处理界面的显示结果；Controller层起到桥梁的作用，来控制View层和Model层通信以此来达到分离视图显示和业务逻辑层。

### 如何理解 MVP：

MVP，全称 Model-View-Presenter，MVP是MVC的一种演进版本，将 MVC 中的 Controller 改为了 Presenter，View通过接口与Presenter进行交互，有效降低 View 的复杂性，避免业务逻辑被塞进 View 中，使得 View 变得臃肿。MVP 模式会解除 View 与 Model 的耦合，同时又带来了良好的可扩展性、可测试性，保证了系统的整洁性、灵活性。在简单的应用中可能会因为各种接口变得复杂，但在稍有规模的应用中，依然能保持结构的整洁和灵活。

###  如何理解 MVVM：

MVVM，全称是 Model-View-ViewModel，和MVP模式相比，MVVM 模式用ViewModel替换了Presenter ，其他层基本上与 MVP 模式一致，ViewModel可以理解成是View的数据模型和Presenter的合体。



### 从 MVC 和 MVP 比较上谈谈MVP：

- MVP 是基于 MVC 模式上演变过来，与 MVC 有一定的相似性，Controller/Presenter 负责逻辑的处理，Model 提供数据，View 负责显示。
- 在 MVC 中，当 Model 被 Controller 更新后，**Model 会直接通知 View 并更新显示**。
- 而在 MVP 中，**Model 与 View 不存在直接关系**，这两者之间间隔着的是 Presenter 层，其负责调控View 与 Model 之间的间接交互，这也是 MVP 和 MVC 两者之间最大的区别。
- 此外 Presenter 与 View、Model 的交互使用接口定义交互操作可以**降低耦合**、简化代码。


### 在MVP模式的三个角色：

#### 1.Presenter 交互中间人

Presenter 作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。它从Model层检索数据后，返回给View层，使得View和Model之间没有耦合，也将业务逻辑从View角色上抽离出来。

#### 2.Model 数据的存取

Model 主要是提供数据的存取功能，Presenter需要通过Model层存储、获取数据，Model就像一个数据仓库。Model是管理数据库和网络获取数据的角色。

#### 3.View 用户界面

View 一般是指Activity、Fragment、View（控件）、ViewGroup等，它含有一个Presenter成员变量。通常 View需要实现一个逻辑接口，将View上的操作转交给 Presenter 进行实现，最后Presenter调用View的逻辑接口将结果返回给View元素。


### MVP的优点：

- 分离了视图逻辑和业务逻辑，**降低了耦合**。
- Activity只处理生命周期的任务，**代码变得更加简洁**。
- 视图逻辑和业务逻辑分别抽象到了View和Presenter的接口中去，**提高代码的可阅读性**。
- Presenter被抽象成接口，可以有多种具体的实现，所以**方便进行单元测试**。
- 把业务逻辑抽到Presenter中去，**避免**后台线程引用着Activity导致Activity的资源无法被系统回收从而引起**内存泄露**。
- Presenter**代码可复用**，一个Presenter可以用于多个View，而不需要更改Presenter的逻辑。

### MVP的缺点：

1. Presenter中除了应用逻辑以外，还有大量的View->Model，Model->View的手动同步逻辑，造成Presenter比较笨重，维护起来会比较困难。
2. 由于对视图的渲染放在了Presenter中，所以视图和Presenter的交互会过于频繁。
3. 如果Presenter过多地渲染了视图，往往会使得它与特定的视图的联系过于紧密。一旦视图需要变更，那么Presenter也需要变更了。
4. 额外的代码复杂度及学习成本

使用MVP 架构之后，多出了许多类；这是必然的；每一个View（Activity或Fragment）都至少需要各自的Model、Presenter和View接口，在加上他们各自的实现，也就是说每一个页面都会有6个java文件（算上Fragment或Activity，因为他就是View的实现），这样一个稍有点规模的APP，类就会变得异常的多，而每一个类的加载又会消耗资源；因此，相较于MVC，这算是MVP最大的缺点了吧。
当然，对于这个问题我们可以通过泛型参数、抽象父类的方式，将一些公用的Model及Presenter抽象出来。这应该就是使用MVP架构的精髓了。





### 参考文章：
- https://www.jianshu.com/p/b7fb7f502ea5
- https://blog.csdn.net/lmj623565791/article/details/46596109
- https://mp.weixin.qq.com/s/QFpHhC-5JkAb4IlMP0nKug



### MVP与Activity、Fragment的生命周期

- 由于Presenter经常性做耗时操作，例如请求网络数据，Presenter持有Activity的强引用，如果在请求结束之前使得Activity被销毁了，那么由于网络请求还没有返回，导致Presenter持有Activity对象，使得Activity无法被回收，此时就会发生内存泄露。

- 解决办法：通过弱引用和Activity、Fragment的生命周期来解决这个问题，建立BasePresenter，是一个泛型类 ，泛型类型为View角色要实现的接口类型。



Presenter不需要在构造函数中传入View对象，而是在View中自由地通过Presenter的attachView方法和detachView方法绑定和解绑View对象，除了attachView和detachView，我们还可以另外声明onResume和onStop方法。
