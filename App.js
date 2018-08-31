/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import codePush from "react-native-code-push";

// class MyApp extends Component {
// }

// MyApp = codePush(MyApp);

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {

  constructor(Props){
    super(Props);
    this.state = {logs: []};
  }

  codePushSync() {
    // this.setState({logs: []]);
    codePush.sync({
      updateDialog: true,
      installMode: codePush.InstallMode.IMMEDIATE
    }, (status) => {
      for (var key in CodePush.SyncStatus){

          if(status === CodePush.SyncStatus[key]){
            this.setState(presState => ({logs: [...prevState.logs, key.replace(/_/g,' ')]}));
            break;

          }
      }
    });
  }


  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>Hello code push 3!</Text>

        <Text style={styles.welcome}>Welcome to React Native MD CI Demo </Text>
        <Text>   This is a demo for CI/CD setup that includes different branches in Github. </Text>
        <Button title="get code push updates" onPress={this.codePushSync}> </Button>


      </View>



    );
  }
}




const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
