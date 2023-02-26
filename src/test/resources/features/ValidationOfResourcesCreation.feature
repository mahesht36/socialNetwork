Feature: Validation of resources creation of social network website for posts and comment creation

  Scenario Outline: Validate and create new post on the social network website
    Given Authorized "<user>" request for post on social network website
    When Authorized user given the "<title>" and "<body>" for creation of post on social network website
    Then User request post is created with "<title>" and "<body>" on social network website
    Examples:
      | user | title | body       |  |
      | 1    | Test  | Test body1 |  |

  Scenario Outline: Validate and create new Comment on post on the social network website
    Given Authorized "<user>" request for Comment on post on social network website
    When Authorized user given valid "<postId>","<name>" and "<email>" for creation of Comment on post
    Then User "<comment>" must created on post with "<name>" and "<email>" on "<postId>"
    Examples:
      | user | postId | name          | email             | comment       |
      | 1    | 1      | Leanne Graham | Sincere@april.biz | test comment1 |