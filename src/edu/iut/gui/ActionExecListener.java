package edu.iut.gui;

import edu.iut.dbaction.DatabaseAction;

/**
 * Listener écoutant la demande d'éxécution d'une action en BDD.
 */
public interface ActionExecListener {
    void onActionExecute(DatabaseAction action, Object data);
}
