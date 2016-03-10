'use strict';

App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.editid = null;
          self.user={username:'',phone:'',email:''};
          self.users=[];
              
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
      					       function(d) {
      						        self.users = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createUser = function(user){
              UserService.createUser(user)
		              .then(
                      self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };

         self.updateUser = function(user, name){
              UserService.updateUser(user, name)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
                  );
          };

         self.deleteUser = function(name){
              UserService.deleteUser(name)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
                  );
          };

          self.fetchAllUsers();

          self.submit = function() {
              if(self.user.name==null){
                  console.log('Saving New User', self.user);    
                  self.createUser(self.user);
              }else{
                  self.updateUser(self.user, self.user.name);
                  console.log('User updated with name ', self.user.name);
              }
              self.reset();
          };
              
          self.edit = function(name){
              console.log('name to be edited', name);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].name == name) {
                     self.user = angular.copy(self.users[i]);
                     self.editid = name;
                     break;
                  }
              }
          };
              
          self.remove = function(name){
              console.log('name to be deleted', name);
              if(self.user.name === name) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteUser(name);
          };

          
          self.reset = function(){
        	  self.editid = null;
              self.user={username:'',phone:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
