import React from 'react';

import AllPostsList from '../containers/AllPostsList';
import AllUsersList from '../containers/AllUsersList';
import MyCommentsList from '../containers/MyCommentsList';
import MyPostsList from '../containers/MyPostsList';
import NewPost from '../containers/NewPost';
import ViewPost from '../containers/ViewPost';
import ViewUser from '../containers/ViewUser';
import AllDenunciesList from "../containers/AllDenunciesList";
import NewDenuncia from "../containers/NewDenuncia";

export default function ViewRoot(props) {
  switch (props.root) {
    case 'myComments':
      return <MyCommentsList />;
    case 'myPosts':
      return <MyPostsList />;
    case 'newPost':
      return <NewPost />;
    case 'post':
      return <ViewPost />;
    case 'posts':
      return <AllPostsList />;
    case 'user':
      return <ViewUser />;
    case 'users':
      return <AllUsersList />;
    case 'denuncies':
      return <AllDenunciesList />
    case 'newDenuncia' :
      return <NewDenuncia />
    default:
      return (
        <span>
          Not Found 404 (look <code>component/Root</code>)
        </span>
      );
  }
}
